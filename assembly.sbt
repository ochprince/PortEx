import AssemblyKeys._ // put this at the top of the file

assemblySettings

jarName in assembly := "portex_alpha_0.2.jar"

test in assembly := {}

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case x if x.endsWith(".exe") => MergeStrategy.discard
    case PathList("importreports", xs @ _*) => MergeStrategy.discard
    case PathList("testfiles", xs @ _*) => MergeStrategy.discard
    case PathList("reports", xs @ _*) => MergeStrategy.discard
    case PathList("exportreports", xs @ _*) => MergeStrategy.discard
    case PathList("x64viruses", xs @ _*) => MergeStrategy.discard
    case x => old(x)
  }
}

//mainClass in assembly := Some("com.github.katjahahn.tools.sigscanner.Jar2ExeScanner")
