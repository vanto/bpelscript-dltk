package iaas.dltk.bpelscript.internal;

import iaas.dltk.bpelscript.IBPELScriptPartitions;

import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.ui.texteditor.ITextEditor;

public class BPELScriptTextTools extends ScriptTextTools {

	private final static String[] LEGAL_CONTENT_TYPES = new String[] {
		IBPELScriptPartitions.BPELSCRIPT_STRING,
		IBPELScriptPartitions.BPELSCRIPT_COMMENT  };

	private IPartitionTokenScanner fPartitionScanner;

	public BPELScriptTextTools(boolean autoDisposeOnDisplayDispose) {
		super(IBPELScriptPartitions.BPELSCRIPT_PARTITIONING,
				LEGAL_CONTENT_TYPES, autoDisposeOnDisplayDispose);
		fPartitionScanner = new BPELScriptPartitionScanner();
	}

	public ScriptSourceViewerConfiguration createSourceViewerConfiguraton(
			IPreferenceStore preferenceStore, ITextEditor editor,
			String partitioning) {
		return new BPELScriptSourceViewerConfiguration(getColorManager(),
				preferenceStore, editor, partitioning);
	}

	public IPartitionTokenScanner getPartitionScanner() {
		return fPartitionScanner;
	}
}
