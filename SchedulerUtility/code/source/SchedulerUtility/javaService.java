package SchedulerUtility;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wm.app.b2b.server.*;
import java.io.*;
import com.wm.lang.ns.NSService;
import java.util.Stack;
// --- <<IS-END-IMPORTS>> ---

public final class javaService

{
	// ---( internal utility methods )---

	final static javaService _instance = new javaService();

	static javaService _newInstance() { return new javaService(); }

	static javaService _cast(Object o) { return (javaService)o; }

	// ---( server methods )---




	public static final void spawnService (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(spawnService)>> ---
		// @sigtype java 3.5
		// [i] field:0:required folder
		// [i] field:0:required service
		// [i] record:0:required inputs
		// [o] object:0:required serviceThread
		IDataCursor cursor = pipeline.getCursor();
		
		String service = null;
		String folder = null;
		IData inputs = null;
		
		if (cursor.first("service"))
		{
		  service = (String) cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'service'");
		}
		
		if (cursor.first("folder"))
		{
		  folder = (String) cursor.getValue();
		}
		else
		{
		  throw new ServiceException("Missing input 'interface'");
		}
		
		if (cursor.first("inputs"))
		{
		  inputs = (IData) cursor.getValue();
		}
		
		try
		{
		  ServiceThread serviceThread = Service.doThreadInvoke(folder, service, inputs);
		
		  if (cursor.first("serviceThread"))
		  {
		    cursor.setValue(serviceThread);
		  }
		  else
		  {
		    cursor.insertAfter("serviceThread", serviceThread);
		  }
		}
		catch (Exception e)
		{
		  throw new ServiceException(e);
		}
		finally
		{
		  cursor.destroy();
		}
			
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	static Reader getReader(IDataCursor cursor, String key)
	{
	  Reader reader = null;
	  if (cursor.first(key))
	  {
	    Object o = cursor.getValue();
	    if (o == null)
	    {
	      reader = new StringReader("");
	    }
	    else if (o instanceof BufferedReader)
	    {
	      reader = (BufferedReader) o;
	    }
	    else if (o instanceof Reader)
	    {
	      reader = new BufferedReader((Reader) o);
	    }
	    else if (o instanceof InputStream)
	    {
	      reader = new BufferedReader(new InputStreamReader((InputStream) o));
	    }
	    else if (o instanceof String)
	    {
	      reader = new BufferedReader(new StringReader((String) o));
	    }
	    else if (o instanceof byte[])
	    {
	      reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream((byte[]) o)));
	    }
	  }
	  return reader;
	
	}
	
	static Writer getWriter(IDataCursor cursor, String key)
	{
	  Writer writer = new StringWriter();
	  if (cursor.first(key))
	  {
	    Object o = cursor.getValue();
	    if (o == null)
	    {
	      return writer;
	    }
	    else if (o instanceof BufferedWriter)
	    {
	      writer = (BufferedWriter) o;
	    }
	    else if (o instanceof Writer)
	    {
	      writer = new BufferedWriter((Writer) o);
	    }
	    else if (o instanceof OutputStream)
	    {
	      writer = new BufferedWriter(new OutputStreamWriter((OutputStream) o));
	    }
	  }
	  return writer;
	
	}
		
	// --- <<IS-END-SHARED>> ---
}

