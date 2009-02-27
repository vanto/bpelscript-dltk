package iaas.dltk.bpelscript.internal;

import iaas.dltk.bpelscript.BPELScriptCorePlugin;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.ui.AbstractDLTKUILanguageToolkit;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class BPELScriptUILanguageToolkit extends AbstractDLTKUILanguageToolkit {

	@Override
	protected AbstractUIPlugin getUIPLugin() {
		return BPELScriptCorePlugin.getDefault();
	}

	@Override
	public IDLTKLanguageToolkit getCoreToolkit() {
		return BPELScriptLanguageToolkit.getDefault();
	}

}
