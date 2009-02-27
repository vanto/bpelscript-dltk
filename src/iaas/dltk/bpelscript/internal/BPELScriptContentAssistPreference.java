package iaas.dltk.bpelscript.internal;

import iaas.dltk.bpelscript.BPELScriptCorePlugin;

import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.dltk.ui.text.completion.ContentAssistPreference;

public class BPELScriptContentAssistPreference extends ContentAssistPreference {

	private static BPELScriptContentAssistPreference instance;
	 
	public static ContentAssistPreference getDefault() {
		if (instance == null) {
			instance = new BPELScriptContentAssistPreference();
		}
		return instance;
	}
 
	protected ScriptTextTools getTextTools() {
		return BPELScriptCorePlugin.getDefault().getTextTools();
	}
}
