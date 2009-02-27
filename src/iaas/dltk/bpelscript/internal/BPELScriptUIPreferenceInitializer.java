package iaas.dltk.bpelscript.internal;

import iaas.dltk.bpelscript.BPELScriptCorePlugin;
import iaas.dltk.bpelscript.IBPELScriptColorConstants;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.dltk.ui.CodeFormatterConstants;
import org.eclipse.dltk.ui.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.editors.text.EditorsUI;

public class BPELScriptUIPreferenceInitializer extends
AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = BPELScriptCorePlugin.getDefault()
		.getPreferenceStore();

		EditorsUI.useAnnotationsPreferencePage(store);
		EditorsUI.useQuickDiffPreferencePage(store);

		// Initialize DLTK default values
		PreferenceConstants.initializeDefaultValues(store);

		// Initialize BPELscript constants
		PreferenceConverter.setDefault(store, IBPELScriptColorConstants.BPELSCRIPT_COMMENT, new RGB(63, 127, 95));
		PreferenceConverter.setDefault(store, IBPELScriptColorConstants.BPELSCRIPT_KEYWORD, new RGB(127, 0, 85));
		PreferenceConverter.setDefault(store, IBPELScriptColorConstants.BPELSCRIPT_STRING,  new RGB(42, 0, 255));
		PreferenceConverter.setDefault(store, IBPELScriptColorConstants.BPELSCRIPT_ANNOTATION,  new RGB(127, 159, 191));

		store.setDefault(IBPELScriptColorConstants.BPELSCRIPT_COMMENT + PreferenceConstants.EDITOR_BOLD_SUFFIX, false);
		store.setDefault(IBPELScriptColorConstants.BPELSCRIPT_COMMENT + PreferenceConstants.EDITOR_ITALIC_SUFFIX, false);

		store.setDefault(IBPELScriptColorConstants.BPELSCRIPT_KEYWORD + PreferenceConstants.EDITOR_BOLD_SUFFIX, true);
		store.setDefault(IBPELScriptColorConstants.BPELSCRIPT_KEYWORD + PreferenceConstants.EDITOR_ITALIC_SUFFIX, false);

		store.setDefault(PreferenceConstants.EDITOR_TAB_WIDTH, 8);
		store.setDefault(PreferenceConstants.EDITOR_SYNC_OUTLINE_ON_CURSOR_MOVE, true);

		store.setDefault(CodeFormatterConstants.FORMATTER_TAB_CHAR, CodeFormatterConstants.TAB);
		store.setDefault(CodeFormatterConstants.FORMATTER_TAB_SIZE, "8");
		store.setDefault(CodeFormatterConstants.FORMATTER_INDENTATION_SIZE,"8");
	}
}
