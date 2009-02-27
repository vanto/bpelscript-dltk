package iaas.dltk.bpelscript;

import org.eclipse.jface.text.IDocument;

public interface IBPELScriptPartitions {
	public final static String BPELSCRIPT_PARTITIONING = "__bpelscript_partitioning";

	public final static String BPELSCRIPT_COMMENT = "__bpelscript_comment";
	public final static String BPELSCRIPT_STRING = "__bpelscript_string";

	public final static String[] PYTHON_PARITION_TYPES = new String[] {
			IBPELScriptPartitions.BPELSCRIPT_STRING,
			IBPELScriptPartitions.BPELSCRIPT_COMMENT,
			IDocument.DEFAULT_CONTENT_TYPE };

}
