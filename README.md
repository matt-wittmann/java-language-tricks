Java Language Tricks
====================

Introduction
------------

This is intended as a demonstration of a few "silly language tricks" in Java for the Thursday, September 7, 2017,
meeting of the [St. Louis Polyglots Meetup](https://www.meetup.com/STL-Polyglots/events/242031101/).

Bag o' Tricks
-------------

### JavaBeans Alternatives

Software developers commonly think Java is a verbose language. It can be, but it can be made less verbose,
even if it isn't idiomatic.

In this example, fields are directly manipulated instead of relying on property accessor methods.

`com.mattwittmann.polyglots.languagetricks.JavaBeanAlternativesTest`
`com.mattwittmann.polyglots.languagetricks.JavaBeanAlternatives`

### Double-Brace Initialization

Historically, initializing collections in Java could be tedious. The upcoming release of Java 9 and other libraries
provide factory methods to help, but in older versions and without dependencies, double-brace initialization could be a
work-around, albeit with its own drawbacks.

`com.mattwittmann.polyglots.languagetricks.DoubleBraceInitializationTest`
`com.mattwittmann.polyglots.languagetricks.DoubleBraceInitialization`

### Fun with Type Erasure

When Sun Microsystems added support for generic types in Java 5, they decided to maintain backwards compatibility
with _type erasure_ and by maintaining source-code support for _raw types_. Essentially, type parameters are hints to
the compiler, but they do not exist at run-time, where the class behaves like its raw type. This means it's easy enough
to trick the compiler into allowing code that will err at run-time, and it's really not a trick or bug but rather the
defined behavior.

`com.mattwittmann.polyglots.languagetricks.RawTypesTest`
`com.mattwittmann.polyglots.languagetricks.RawTypes`

### Subverting Privacy Through Reflection

Java's Reflection API enables developers to play with classes' metadata and use that to invoke methods, access fields,
etc. Using this, the `private` visibility modifier can be outright ignored.

In this example, we pay homage to [The Brilliant Paula Bean](https://thedailywtf.com/articles/The_Brillant_Paula_Bean)
and get to the core of Paula's brilliance, skipping the janky business logic eclipsing it.

`com.mattwittmann.polyglots.languagetricks.PrivacySubversionTest`
`com.mattwittmann.polyglots.languagetricks.NotPaulaBean`

### Dynamically Defining Behavior Through Proxy Objects

The Java Reflection API also supports object proxies. These provide a mechanism to define implementations to class
interfaces at run-time, allowing the wrapping of a concrete instance, adding new behavior, or fabricating the
whole implementation from scratch.

In this example, three methods are implemented using nothing more than a simple switch block, and an exception is
thrown for any other method that may be invoked.

`com.mattwittmann.polyglots.languagetricks.FunByProxyTest`
`com.mattwittmann.polyglots.languagetricks.FunByProxy`

### Java Byte-Code Instrumentation

The Java Reflection API allows some basic metaprogramming, but the API is bulky, and its use comes with a performance
penalty. Far more powerful is bytecode instrumentation. Byte-code instrumentation enables the Java virtual
machine to load or reload whole class definitions dynamically. Instrumentation can also be made a phase of the
build process. The process can be cumbersome, but once a redefined class definition is loaded, it acts just like
any other class definition.

The raw Java API for byte-code instrumentation is extremely low level: working with byte arrays. The
[ASM](http://asm.ow2.org/) library adds some mnemonics and support on top of this but is comparable to working
in assembly poked into an editor through visitor patterns. This example uses [ByteBuddy](http://bytebuddy.net/),
a more fluent library built on top of ASM.

`com.mattwittmann.polyglots.languagetricks.BytecodeInstrumentationTest`
`com.mattwittmann.polyglots.languagetricks.BytecodeInstrumentation`
