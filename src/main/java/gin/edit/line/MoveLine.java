package gin.edit.line;

import gin.SourceFile;
import gin.SourceFileLine;
import gin.edit.Edit;

import java.util.List;
import java.util.Random;

public class MoveLine extends LineEdit {

    public String sourceFile;
    public int sourceLine;
    public String destinationFile;
    public int destinationLine;

    /**
     * create a random MoveLine for the given SourceFile, using the provided RNG
     *
     * @param sourceFile to create an edit for
     * @param rng        random number generator, used to choose the target line
     */
    public MoveLine(SourceFile sourceFile, Random rng) {
        SourceFileLine sf = (SourceFileLine) sourceFile;
        List<Integer> targetMethodLines = sf.getLineIDsNonEmptyOrComments(true);

        this.sourceFile = sourceFile.getFilename();
        this.sourceLine = targetMethodLines.get(rng.nextInt(targetMethodLines.size()));
        this.destinationFile = sourceFile.getFilename();
        this.destinationLine = targetMethodLines.get(rng.nextInt(targetMethodLines.size()));
    }

    public MoveLine(String sourceFile, int sourceLine, String destinationFile, int destinationLine) {
        this.sourceFile = sourceFile;
        this.sourceLine = sourceLine;
        this.destinationFile = destinationFile;
        this.destinationLine = destinationLine;
    }

    @Override
    public SourceFile apply(SourceFile sourceFile) {
        if (sourceLine == destinationLine) {
            return sourceFile; // no-op
        }

        SourceFileLine sf = (SourceFileLine) sourceFile;
        String line = sf.getLine(sourceLine);
        if (line != null) { // source not already deleted
            sf = sf.removeLine(sourceLine);
            sf = sf.insertLine(destinationLine, line);
        }

        return sf;
    }

    @Override
    public String toString() {
        return this.getClass().getCanonicalName() + " " + sourceFile + ":" + sourceLine + " -> " + destinationFile + ":" + destinationLine;
    }

    public static Edit fromString(String description) {
        String[] tokens = description.split("\\s+");
        String source = tokens[1];
        String destination = tokens[3];
        String[] sourceTokens = source.split(":");
        String sourceFile = sourceTokens[0];
        int sourceLine = Integer.parseInt(sourceTokens[1]);
        String[] destTokens = destination.split(":");
        String destFile = destTokens[0];
        int destLine = Integer.parseInt(destTokens[1]);
        return new MoveLine(sourceFile, sourceLine, destFile, destLine);
    }

}
