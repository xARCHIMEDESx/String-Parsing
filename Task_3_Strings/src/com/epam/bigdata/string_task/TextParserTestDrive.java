package com.epam.bigdata.string_task;

public class TextParserTestDrive {

	public static void main(String[] args) {
		TextParser textParser = new TextParser(new FileParser().parsingFromFile("inputText.txt"));
		textParser.textToSentences();
		textParser.wordsCount();
		textParser.shortWordsReplacement();
	}
}
