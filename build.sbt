import Dependencies.*

lazy val compilerOptions = Seq(
  "-unchecked",  // Enable additional warnings where generated code depends on assumptions.
  "-explain",          // Explain errors in more detail.
  "-explain-types",
  "-encoding", "utf8", // Specify character encoding used by source files.
  "-feature",          // Emit warning and location for usages of features that should be imported explicitly.
  "-source:future",    // force future deprecation warnings.
  "-rewrite",          // 
  "-indent",           // Together with -rewrite, remove {…} syntax when possible due to significant indentation.
  "-deprecation",      // Emit warning and location for usages of deprecated APIs. Together with -rewrite, ....
  //"-new-syntax",     // Require then and do in control expressions. 
                       // -- illegal combination of -rewrite targets: -new-syntax and -indent
  //"-Xsemanticdb",    // the Scala 3 compiler has built-in SemanticDB support. 
  //"-Xcheck-macros",  // Additional check useful during development
  "-Xfatal-warnings"   // Fail on warnings, not just errors
  ,
  // https://hackernoon.com/null-the-billion-dollar-mistake-8t5z32d6
  // 
  "-Yexplicit-nulls",    // to allow null, using 'import scala.language.unsafeNulls'
  //"-language:implicitConversions",  // Use of implicit conversion, using import scala.language.implicitConversions
  //"-Ycc",              // Enable support for capture checking. https://docs.scala-lang.org/scala3/reference/experimental/index.html
  "-Ysafe-init"          // https://docs.scala-lang.org/scala3/reference/other-new-features/safe-initialization.html
)

lazy val root = (project in file("."))
  .settings(
    organization in ThisBuild := "elephants",
    scalaVersion in ThisBuild := "3.3.1",
    version      in ThisBuild := "0.1.0-SNAPSHOT",
    name := "elephants",
	scalacOptions ++= compilerOptions,
    libraryDependencies += scalaTest % Test
  )
