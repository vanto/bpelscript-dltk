package iaas.dltk.bpelscript.internal.parser;

import org.eclipse.dltk.ast.parser.ISourceParser;
import org.eclipse.dltk.ast.parser.ISourceParserFactory;

public class BPELScriptSourceParserFactory implements ISourceParserFactory {

	public BPELScriptSourceParserFactory() {
	}

	@Override
	public ISourceParser createSourceParser() {
		return new BPELScriptSourceParser();
	}

}
