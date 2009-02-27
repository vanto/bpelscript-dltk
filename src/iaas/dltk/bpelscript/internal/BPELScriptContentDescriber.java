package iaas.dltk.bpelscript.internal;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.dltk.core.ScriptContentDescriber;

public class BPELScriptContentDescriber extends ScriptContentDescriber {

	@Override
	public int describe(Reader arg0, IContentDescription arg1)
			throws IOException {
		return ScriptContentDescriber.INDETERMINATE;
	}

}
