package org.eclipse.ltk.core.refactoring.resource;

import static org.junit.Assert.assertEquals;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

public class GetNameTest {
	private RenameResourceChange renameChange;
	
	 @Test
	 public void testGetName_validPathAndNewName() {
		 IPath resourcePath = new Path("/project/old_name.java");
		 String newName = "new_name.java";
		 renameChange = new RenameResourceChange(resourcePath, newName);
		 String name = renameChange.getName();
		 assertEquals("Rename 'project/old_name.java' to 'new_name.java'", name);
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void testGetName_nullPathAndNewName() {
		 IPath resourcePath = null;
		 String newName = "new_name.java";
		 renameChange = new RenameResourceChange(resourcePath, newName);
		 String name = renameChange.getName();
		 assertEquals("Rename '' to 'new_name.java'", name);
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void testGetName_validPathAndNullNewName() {
		 IPath resourcePath = new Path("/project/old_name.java");
		 String newName = null;
		 renameChange = new RenameResourceChange(resourcePath, newName);
		 String name = renameChange.getName();
		 assertEquals("Rename 'project/old_name.java' to 'project/'", name);
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void testGetName_validPathAndEmptyNewName() {
		 IPath resourcePath = new Path("/project/old_name.java");
		 String newName = "";
		 renameChange = new RenameResourceChange(resourcePath, newName);
		 String name = renameChange.getName();
		 assertEquals("Rename 'project/old_name.java' to 'project/'", name);
	 }
	 
	 @Test
	 public void testGetName_EmptyPathAndValidNewName() {
		 IPath resourcePath = new Path("");
		 String newName = "new_name";
		 renameChange = new RenameResourceChange(resourcePath, newName);
		 String name = renameChange.getName();
		 assertEquals("Rename '' to 'new_name'", name);
	 }
	 
	 
	 
	
	 
	 
}
