package org.eclipse.ltk.core.refactoring.resource;

import static org.junit.Assert.*;


import org.eclipse.core.runtime.IPath;
import org.junit.Test;

public class RenamedResourcePathTest {

	@Test
	public void testIdealRenamedResource() {
		IPath path = org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java");
		String newName = "new_name.java";
	
		IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);
		assertEquals(org.eclipse.core.runtime.Path.fromOSString("/path/new_name.java"), renamedPath);
	}
	
	@Test
	public void testRenamedResourceEmptyNewName() {
		IPath path = org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java");
		String newName = "";
		IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);
		assertEquals(org.eclipse.core.runtime.Path.fromOSString("/path/"),renamedPath);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRenamedResourceNullNewName() {
		IPath path = org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java");
		String newName = null;
		IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);
		assertEquals(org.eclipse.core.runtime.Path.fromOSString("/path"),renamedPath);
	}
	
	@Test
	public void testRenamedResourceEmptyPath() {
		IPath path = org.eclipse.core.runtime.Path.fromOSString("");
		String newName = "new_name";
		IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);
		assertEquals(org.eclipse.core.runtime.Path.fromOSString("new_name"),renamedPath);
	}
	
	@Test
	public void testRenamedResourceEmptyPathEmptyNewName() {
		IPath path = org.eclipse.core.runtime.Path.fromOSString("");
		String newName = "";
		IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);
		assertEquals(org.eclipse.core.runtime.Path.fromOSString(""),renamedPath);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRenamedResourceNullNewNameEmptyPath() {
		IPath path = org.eclipse.core.runtime.Path.fromOSString("");
		String newName = null;
		IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);
		assertEquals(org.eclipse.core.runtime.Path.fromOSString(""),renamedPath);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRenamedResourceNullPath() {
		IPath path = org.eclipse.core.runtime.Path.fromOSString(null);
		String newName = "new_name";
		IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);
		assertEquals(org.eclipse.core.runtime.Path.fromOSString("new_name"),renamedPath);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRenamedResourceNullPathEmptyNewName() {
		IPath path = org.eclipse.core.runtime.Path.fromOSString(null);
		String newName = "";
		IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);
		assertEquals(org.eclipse.core.runtime.Path.fromOSString(""),renamedPath);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRenamedResourceNullPathNullNewName() {
		IPath path = org.eclipse.core.runtime.Path.fromOSString(null);
		String newName = null;
		IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);
		assertEquals(org.eclipse.core.runtime.Path.fromOSString(""),renamedPath);
	}
	
	@Test
	public void testRenamedResourcePathDoesNotModifyOriginalPath() {
	    IPath path = org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java");
	    String newName = "new_name.java";

	    IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);

	    assertEquals(path, org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java"));
	    assertEquals("/path/new_name.java", renamedPath.toString());
	}
	
	@Test
	public void testRenameResourcePathReturnsValidInstance() {
		IPath path = org.eclipse.core.runtime.Path.fromOSString("/path/old_name.java");
		String newName = "new_name.java";
		
		IPath renamedPath = RenameResourceChange.renamedResourcePath(path, newName);
		assertTrue(renamedPath instanceof IPath);
	}
		

}
