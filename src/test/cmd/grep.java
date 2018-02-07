package test.cmd;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.tree.DefaultMutableTreeNode;
import driver.*;

/**
 * grep REGEX path1 path2 ...: Lists lines from the File that contain REGEX.
 * grep -r REGEX path1 path2 ... or grep -R REGEX path1 path2 ...: When path
 * is a Directory then traverse the Directory, and files and list all lines 
 * contain REGEX. Otherwise, if path is a File then list lines that contain REGEX.
 */
public class grep extends Command{
	
	/**
	 * Runs the code unique to this command.
	 * 
   	 * @param args Array of arguments to be passed by JShell.
	 */
	public void execute(String[] args) throws Exception {
			
		// If -r or -R provided.
		if (args.length > 0 && (args[0].equals("-r") || args[0].equals("-R"))){
			//Checking if enough information is provided to run the command.
			if (args.length > 2){
				DefaultMutableTreeNode node;
				ArrayList<String> fileContent;
				ArrayList<String> notFile = new ArrayList<String>();
				
				//Iterating over all the paths provided.
				for(int i=2; i<args.length; i++){
					if(args[i].equals("/")){
						node = JShell.os.getRoot();
					}
					else{
						node = getNode(args[i]);
					}
					//When user provides unknown entry.
					if (node == null){
						notFile.add(args[i]);
					}
					//When path is a Directory.
					else if (node.getUserObject() instanceof Directory){
						//Getting the children of the Directory and Iterating over them.
						ArrayList<DefaultMutableTreeNode> children = getChildren(node);
						for (DefaultMutableTreeNode entry: children){
							//If children is a Directory then recursive call is made on it.
							if(entry.getUserObject() instanceof Directory){
								//Recursive call made.
								recursiveDisplay(entry, args[1]);
							}
							//If children is a File then we start printing matching lines.
							else{
								fileContent = ((File) entry.getUserObject()).readEachLine();
								String msg = buildPath(entry)+ ":";
								System.out.println(msg);
								//Using helper method to print matching lines.
								printMatchingLine(fileContent, args[1]);
							}
						}
					}
					//When path is a File.
					else{
						fileContent = ((File) node.getUserObject()).readEachLine();
						//Using helper method to print matching lines.
						String msg = buildPath(node)+ ":";
						System.out.println(msg);
						printMatchingLine(fileContent, args[1]);
					}
				}
				//Telling user which paths were not File type.
				for (String entry: notFile){
					System.out.println(entry+ " is not a File.");
				}	
			}
			//If enough information is not provided.
			else{
				System.out.println("Invalid command, please try again.");
			}
		}
		// If -r or -R is not provided.
		else{
			//If enough information is provided.
			if (args.length >= 2){
				nonRecursiveDisplay(args);
			}
			//If enough information is not provided.
			else{
				System.out.println("Invalid command, please try again.");
			}
		}
		
	}
	
    /**
     * Runs the code when -r or -R is not present.
     * 
     * @param args Array of arguments.
     */
	public void nonRecursiveDisplay(String[] args){
		DefaultMutableTreeNode node;
		ArrayList<String> fileContent;
		ArrayList<String> notFile = new ArrayList<String>();
		
		//Iterating over lines to find matching String in them.
		for(int i=1; i<args.length; i++){
			node = getNode(args[i]);
			//Catching paths that are either invalid or Directories.
			if (node == null || !(node.getUserObject() instanceof File)){
				notFile.add(args[i]);
			}
			else{
				//Use helper method to print matching lines in the File.
				fileContent = ((File) node.getUserObject()).readEachLine();
				//Calling helper method.
				printMatchingLine(fileContent, args[0]);
			}
		}
		//Telling user which paths were not File type.
		for (String entry: notFile){
			System.out.println(entry+ " is not a File.");
		}
	}
	
    /**
     * Helper method to print matching lines recursively.
     * 
     * @param path Path to find Files that contain match.
     * @param match Matching word to be found in lines.
     */
	public void recursiveDisplay(DefaultMutableTreeNode path, String match){
		ArrayList<DefaultMutableTreeNode> children = getChildren(path);
		ArrayList<String> fileContent;
		//Iterating over the children of Directory.
		for (DefaultMutableTreeNode entry: children){
			//When children is Directory then we make recursive call on it.
			if(entry.getUserObject() instanceof Directory){
				recursiveDisplay(entry, match);
			}
			else{
				//Use helper method to print matching lines in the File.
				fileContent = ((File) entry.getUserObject()).readEachLine();
				String msg = buildPath(entry)+ ": ";
				System.out.println(msg);
				//Calling helper method.
				printMatchingLine(fileContent, match);
			}
		}
	}
	
	
	/**
	 * Print lines that contain match.
	 * 
	 * @param lines Array of lines from File.
	 * @param match Matching word to be found in lines.
	 * @param msg The message to print to the user.
	 */
	public void printMatchingLine(ArrayList<String> lines, String match){
		Pattern p = Pattern.compile("(.*)"+ match+"(.*)");
		//Iterating over lines in File.
		for(int a=0; a<lines.size(); a++){
			String currentLine = lines.get(a);
			Matcher m = p.matcher(currentLine);
			
			//Print matching lines.
			if (m.find()){
				System.out.print(currentLine);
			}
		}
	}
	
	/**
	 * Provides the children of a given node.
	 * 
	 * @param node Node whose children to find.
	 * 
	 * @return The Children of a node.
	 */
	private ArrayList<DefaultMutableTreeNode> getChildren(DefaultMutableTreeNode node) {
		ArrayList<DefaultMutableTreeNode> childList = new ArrayList<DefaultMutableTreeNode>();
		int numberOfChildren = node.getChildCount();
		if (numberOfChildren > 0) {
			for (int i = 0; i < numberOfChildren; i++) {
				DefaultMutableTreeNode child =
						(DefaultMutableTreeNode) node.getChildAt(i);
				childList.add(child);
			}
		}
		return childList;
	}
	
	/**
	 * Prints documentation for this command.
	 */
	public void doc(){
		System.out.println("[grep REGEX path1 path2 ...]\n"
			+"Lists lines from a file that contain REGEX.\n"
			+"[grep -r REGEX path1 path2 ...] or [grep -R REGEX path1 path2 ...]\n"
			+"If path is a directory then recursively traverse the directory, and "
			+"all files and list lines that contain REGEX.\n"
			+"If path is s files the list lines that contain REGEX.");
	}
}
