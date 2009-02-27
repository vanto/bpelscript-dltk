package iaas.dltk.bpelscript.internal.ui.editor;

import iaas.dltk.bpelscript.BPELScriptCorePlugin;
import iaas.dltk.bpelscript.IBPELScriptPartitions;
import iaas.dltk.bpelscript.internal.BPELScriptLanguageToolkit;
import iaas.dltk.bpelscript.internal.BPELScriptTextTools;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.internal.ui.editor.ScriptEditor;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.ui.IEditorInput;

public class BPELScriptEditor extends ScriptEditor {
	public static final String EDITOR_ID = "iaas.dltk.bpelscript.ui.editor";
	public static final String EDITOR_CONTEXT = "#BPELScriptEditorContext";
	 
	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId(EDITOR_CONTEXT);
	}
 
	@Override
	public String getEditorId() {
		return EDITOR_ID;
	}

	@Override
	public IDLTKLanguageToolkit getLanguageToolkit() {
		return BPELScriptLanguageToolkit.getDefault();
	}

	@Override
	protected IPreferenceStore getScriptPreferenceStore() {
		return BPELScriptCorePlugin.getDefault().getPreferenceStore();
	}

	public ScriptTextTools getTextTools() {
		return BPELScriptCorePlugin.getDefault().getTextTools();
	}
	
	protected void connectPartitioningToElement(IEditorInput input,
			IDocument document) {
		if (document instanceof IDocumentExtension3) {
			IDocumentExtension3 extension = (IDocumentExtension3) document;
			if (extension.getDocumentPartitioner(IBPELScriptPartitions.BPELSCRIPT_PARTITIONING) == null) {
				BPELScriptTextTools tools = BPELScriptCorePlugin.getDefault().getTextTools();
		                tools.setupDocumentPartitioner(document, IBPELScriptPartitions.BPELSCRIPT_PARTITIONING);
			}
		}
	}
}
