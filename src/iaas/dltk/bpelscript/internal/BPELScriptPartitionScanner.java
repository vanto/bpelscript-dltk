package iaas.dltk.bpelscript.internal;

import iaas.dltk.bpelscript.IBPELScriptPartitions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.PatternRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;

public class BPELScriptPartitionScanner extends RuleBasedPartitionScanner {

	public BPELScriptPartitionScanner() {
		IToken string = new Token(IBPELScriptPartitions.BPELSCRIPT_STRING);
		IToken comment = new Token(IBPELScriptPartitions.BPELSCRIPT_COMMENT);

		List<PatternRule> rules = new ArrayList<PatternRule>();

		rules.add(new EndOfLineRule("//", comment));
		rules.add(new SingleLineRule("'", "'", string, '\\')); 				
		rules.add(new MultiLineRule("\"", "\"", string, '\\'));


		IPredicateRule[] result = new IPredicateRule[rules.size()];
		rules.toArray(result);
		setPredicateRules(result);
	}
}
