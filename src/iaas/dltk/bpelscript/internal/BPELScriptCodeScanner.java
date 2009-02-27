package iaas.dltk.bpelscript.internal;

import iaas.dltk.bpelscript.IBPELScriptColorConstants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dltk.ui.text.AbstractScriptScanner;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

public class BPELScriptCodeScanner extends AbstractScriptScanner {

	private static String[] fgKeywords = { "namespace", "import", "process", "try", "parallel", "and", "join", "signal", "for", "invoke", "receive", "reply", "catch" };
	private static String fgTokenProperties[] = new String[] {
		IBPELScriptColorConstants.BPELSCRIPT_COMMENT,
		IBPELScriptColorConstants.BPELSCRIPT_DEFAULT,
		IBPELScriptColorConstants.BPELSCRIPT_KEYWORD };

	public BPELScriptCodeScanner(IColorManager manager, IPreferenceStore store) {
		super(manager, store);
		this.initialize();
	}

	protected String[] getTokenProperties() {
		return fgTokenProperties;
	}

	@SuppressWarnings("unchecked")
	protected List createRules() {
		List rules = new ArrayList();
		IToken keyword = this.getToken(IBPELScriptColorConstants.BPELSCRIPT_KEYWORD);
		IToken comment = this.getToken(IBPELScriptColorConstants.BPELSCRIPT_COMMENT);
		IToken annotation = this.getToken(IBPELScriptColorConstants.BPELSCRIPT_ANNOTATION);
		IToken other = this.getToken(IBPELScriptColorConstants.BPELSCRIPT_DEFAULT);
		// Add rule for annotations.
		rules.add(new EndOfLineRule("@", annotation));
		// Add rule for single line comments.
		rules.add(new EndOfLineRule("#", comment));
		// Add generic whitespace rule.
		rules.add(new WhitespaceRule(new BPELScriptWhitespaceDetector()));
		// Add word rule for keywords.
		WordRule wordRule = new WordRule(new BPELScriptWordDetector(), other);
		for (int i = 0; i < fgKeywords.length; i++) {
			wordRule.addWord(fgKeywords[i], keyword);
		}
		rules.add(wordRule);
		this.setDefaultReturnToken(other);
		return rules;
	}
	
	public class BPELScriptWhitespaceDetector implements IWhitespaceDetector {
		public boolean isWhitespace(char character) {
			return Character.isWhitespace(character);
		}
	}
	
	public class BPELScriptWordDetector implements IWordDetector {
		public boolean isWordPart(char character) {
			return Character.isJavaIdentifierPart(character) || character == '-';
		}
		public boolean isWordStart(char character) {
			return Character.isJavaIdentifierStart(character);
		}
	}
}
