# Basic-Compiler-Example
This is a very basic compiler example which just perform Lexical Analysis and Parsing



This is a very basic compiler which just performs Lexical Analysis and Parsing for a very basic language.

The context fee language for the Grammar is -

E -> xF
F -> xF | int

Non Terminals - E and F
Terminals - x and int

Valid strings - xint , xxint , xxxint xxxxint etc....

To check the Lexical Analyser , run the file Tokenizer.java
To check the parsing , run the file Parser.java