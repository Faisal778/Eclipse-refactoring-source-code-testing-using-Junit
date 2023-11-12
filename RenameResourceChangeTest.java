package org.eclipse.ltk.core.refactoring.resource;

import static org.junit.Assert.*;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Before;
import org.junit.Test;


public class RenameResourceChangeTest {

	private IPath resourcePath;
	private String newName;
	private long stampToRestore;

	 @Test
	    public void testRenameResourceChange() {
		 	resourcePath = org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java");
	        String newName = "new_resource.java";
	        long stampToRestore = 12345678;

	        RenameResourceChange renameResourceChange = new RenameResourceChange(resourcePath, newName, stampToRestore);
	        assertEquals("new_resource.java",renameResourceChange.getNewName());
	        assertEquals(org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java"),renameResourceChange.getResourcePath());
	    }
	 
	 @Test(expected = IllegalArgumentException.class)
	    public void testRenameResourceChangeEmptyNewName() {
		 	resourcePath = org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java");
	        String newName = "";
	        long stampToRestore = 12345678;
	        
	        RenameResourceChange renameResourceChange = new RenameResourceChange(resourcePath, newName, stampToRestore);
	    }
	 
	 
	 @Test(expected = IllegalArgumentException.class)
	    public void testRenameResourceChangeNullNewName() {
		 	resourcePath = org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java");
	        String newName = null;
	        long stampToRestore = 12345678;

	        RenameResourceChange renameResourceChange = new RenameResourceChange(resourcePath, newName, stampToRestore);
	        System.out.println(renameResourceChange);
	    }
	 
	 @Test(expected =IllegalArgumentException.class)
	    public void testRenameResourceChangeNullresourcePath() {
		 	resourcePath = null;
	        String newName = "new_name.java";
	        long stampToRestore = 12345678;

	        RenameResourceChange renameResourceChange = new RenameResourceChange(resourcePath, newName, stampToRestore);
	        System.out.println(renameResourceChange);
	    }
	 
	 @Test(expected = Error.class)
	    public void testRenameResourceChangeNullstampToRestore() {
		 	resourcePath = org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java");
	        String newName = "new_name.java";
	        long stampToRestore = null;

	        RenameResourceChange renameResourceChange = new RenameResourceChange(resourcePath, newName, stampToRestore);
	        System.out.println(renameResourceChange);

	    }
	 
	 @Test
	    public void testRenameResourceChangeNullresourcePathNullewName() {
		 	resourcePath = null;
	        String newName = null;
	        long stampToRestore = 12345678;

//	        RenameResourceChange renameResourceChange = new RenameResourceChange(resourcePath, newName, stampToRestore);
//	        System.out.println(renameResourceChange);

	       // IResource resource = renameResourceChange.getModifiedResource(); //returns getResource()
			
		   // assertEquals(resourcePath,resource.getFullPath());
	        assertThrows(IllegalArgumentException.class, () -> new RenameResourceChange(resourcePath, newName, stampToRestore));

	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	@Before
	public void setUp() {
		resourcePath = org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java");
        newName = "new_name.java";//"name";
        stampToRestore = 12345;
	}
	
	
	
	@Test
	public void testValidConstructor() {
		RenameResourceChange change = new RenameResourceChange(resourcePath, newName);
        assertNotNull(change);
	}
	
	@Test
	public void testValidConstructorWithStampToRestore(){
		RenameResourceChange change = new RenameResourceChange(resourcePath,newName, stampToRestore);
		assertNotNull(change);
	}
	
	@Test
	public void testValidNewName() {
	    // Create a new instance of the RenameResourceChange class using the protected constructor.
	    RenameResourceChange renameResourceChange = new RenameResourceChange(new Path("/path/old_name.java"), "new_name.txt", IResource.NULL_STAMP);

	    // Assert that the resource path, new name, and stamp to restore are all set correctly.
	  //  assertEquals(new Path("/path/to/file.txt"), renameResourceChange.getResourcePath());
	    assertEquals("new_name.txt", renameResourceChange.getNewName());
	   // assertEquals(IResource.NULL_STAMP, renameResourceChange.getStampToRestore());
	}
	
	//@Test
	public void testValidPath() {
	  // Create a new instance of the RenameResourceChange class using the protected constructor.
	    RenameResourceChange renameResourceChange = new RenameResourceChange(new Path("/path/old_name.java"), "new_name.txt", IResource.NULL_STAMP);
	  // IPath resourcePath = renameResourceChange.getResource();
		IResource resource = renameResourceChange.getModifiedResource(); //returns getResource()
		
	    assertEquals(resourcePath,resource.getFullPath());
	   
	}
	
	@Test//(expected = IllegalArgumentException.class)
	public void testNullResourcePath() {
		//resourcePath = null;
	//	RenameResourceChange renameResourceChange = new RenameResourceChange(null, newName, stampToRestore);	
		assertThrows(IllegalArgumentException.class, () -> new RenameResourceChange(null, "new_name.java", IResource.NULL_STAMP));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullNewName() {
		//newName = null;
		RenameResourceChange renameResourceChange = new RenameResourceChange(resourcePath, null, stampToRestore);	

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullNameLength() {
		RenameResourceChange renameResourceChange = new RenameResourceChange(resourcePath, "" , stampToRestore);	

	}
	
	
	

	 
	 
	}
	

	

