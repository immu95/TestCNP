package TestFlow;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.StringTokenizer;
import java.text.*;
import java.util.Date;
import java.io.*;
import com.wm.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class flow

{
	// ---( internal utility methods )---

	final static flow _instance = new flow();

	static flow _newInstance() { return new flow(); }

	static flow _cast(Object o) { return (flow)o; }

	// ---( server methods )---



    public static final Values multiConcat (Values in)
    {
        Values out = in;
		// --- <<IS-START(multiConcat)>> ---
		// @sigtype java 3.0
		// [i] field:0:required inStr1
		// [i] field:0:required inStr2
		// [i] field:0:required inStr3
		// [i] field:0:required inStr4
		// [i] field:0:required inStr5
		// [i] field:0:required inStr6
		// [i] field:0:required inStr7
		// [i] field:0:required inStr8
		// [i] field:0:required inStr9
		// [i] field:0:required inStr10
		// [o] field:0:required outStr
		/** Service takes in up to ten strings, checks them for null (see Shared tab method checkNull), and
		  * concatenates all of them together. checkNull returns a "" if the String is null, effectively
		  * cancelling out its effect on the concatenation. Returns the concatenated String as "outStr".
		  *
		  * 
		  */
		
		String str1 = checkNull(in.getString("inStr1"));
		String str2 = checkNull(in.getString("inStr2"));
		String str3 = checkNull(in.getString("inStr3"));
		String str4 = checkNull(in.getString("inStr4"));
		String str5 = checkNull(in.getString("inStr5"));
		String str6 = checkNull(in.getString("inStr6"));
		String str7 = checkNull(in.getString("inStr7"));
		String str8 = checkNull(in.getString("inStr8"));
		String str9 = checkNull(in.getString("inStr9"));
		String str10 = checkNull(in.getString("inStr10"));
		
		String outStr = str1 + str2 + str3 + str4 + str5 + str6 + str7 + str8 + str9 + str10;
		
		out.put( "outStr", outStr );
			
		// --- <<IS-END>> ---
        return out;
                
	}

	// --- <<IS-START-SHARED>> ---
	/** Used by "multiConcat"
	  * 
	  * 
	  */
	private static String checkNull(String inputString)
	{
		if( inputString == null )
			return "";
		else
			return inputString;
	}
	// --- <<IS-END-SHARED>> ---
}

