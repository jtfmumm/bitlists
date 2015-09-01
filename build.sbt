//lazy val scalacheck = "org.scalacheck" %% "scalacheck" % "1.12.4"


lazy val commonSettings = Seq(
  organization := "com.jtfmumm",
  version := "0.1.0"
  // scalaVersion := "2.11.4"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "bitlists",
    //libraryDependencies += scalacheck,
    //mainClass := Some("dir.MainName"),
    publishMavenStyle := true,
    publishTo := {
      val nexus = "https://oss.sonatype.org/"
      if (isSnapshot.value)
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
    },
    publishArtifact in Test := false,
    pomExtra := (
      <url>http://github.com/jtfmumm/bitlists</url>
        <licenses>
          <license>
            <name>MIT</name>
            <url>http://opensource.org/licenses/MIT</url>
            <distribution>repo</distribution>
          </license>
        </licenses>
        <scm>
          <url>git@github.com:jtfmumm/bitlists.git</url>
          <connection>scm:git:git@github.com:jtfmumm/bitlists.git</connection>
        </scm>
        <developers>
          <developer>
            <id>jtfmumm</id>
            <name>FULL NAME</name>
            <url>http://PERSONAL WEBSITE</url>
          </developer>
        </developers>)
  )
