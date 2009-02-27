package iaas.dltk.bpelscript.internal.parser;

import iaas.dltk.bpelscript.internal.BPELScriptNature;

import org.eclipse.dltk.compiler.ISourceElementRequestor;
import org.eclipse.dltk.compiler.ISourceElementRequestor.TypeInfo;
import org.eclipse.dltk.core.AbstractSourceElementParser;
import org.eclipse.dltk.core.ISourceModuleInfoCache.ISourceModuleInfo;

public class BPELScriptSourceElementParser extends AbstractSourceElementParser {

	public void parseSourceModule(char[] contents, ISourceModuleInfo astCache,
			char[] filename) {
		ISourceElementRequestor requestor = getRequestor();

		requestor.enterModule();
		TypeInfo info = new TypeInfo();
		String cont = new String(contents);
		int start = cont.indexOf("process");
		if (start == -1) {
			info.name = "Unknown BPELscript";	
		} else {
			start = start + 1 + "process".length();
			int end = cont.indexOf(' ', start);
			info.name = cont.substring(start, end);
		}
		
		requestor.enterType(info);
		requestor.exitType(0);
		requestor.exitModule(0);
	}

	@Override
	protected String getNatureId() {
		return BPELScriptNature.BPELSCRIPT_NATURE;
	}

}
