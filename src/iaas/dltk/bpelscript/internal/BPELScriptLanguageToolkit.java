package iaas.dltk.bpelscript.internal;

import org.eclipse.dltk.core.AbstractLanguageToolkit;
import org.eclipse.dltk.core.IDLTKLanguageToolkit;

public class BPELScriptLanguageToolkit extends AbstractLanguageToolkit {
	private static BPELScriptLanguageToolkit toolkit;

	public static IDLTKLanguageToolkit getDefault() {
		if (toolkit == null) {
			toolkit = new BPELScriptLanguageToolkit();
		}
		return toolkit;
	}

	@Override
	public String getLanguageContentType() {
		return "iaas.dltk.bpelscript.content-type";
	}

	@Override
	public String getLanguageName() {
		return "BPELscript";
	}

	@Override
	public String getNatureId() {
		return BPELScriptNature.BPELSCRIPT_NATURE;
	}

}
