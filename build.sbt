// Common settings

name := "sbt-tpolecat"
description := "scalac options for the enlightened"
organization := "io.github.davidgregory084"

organizationName := "David Gregory"
startYear := Some(2019)
licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/DavidGregory084/sbt-tpolecat"),
    "scm:git:git@github.com:DavidGregory084/sbt-tpolecat.git"
  )
)
developers := List(
  Developer(
    "DavidGregory084",
    "David Gregory",
    "davidgregory084@gmail.com",
    url("https://github.com/DavidGregory084")
  )
)
homepage := scmInfo.value.map(_.browseUrl)

crossSbtVersions := Seq("0.13.18", "1.3.4")

enablePlugins(SbtPlugin)

// Dependencies

addSbtPlugin("org.lyranthe.sbt" % "partial-unification" % "1.1.2")

// License headers

Compile / headerCreate := { (Compile / headerCreate).triggeredBy(Compile / compile).value }

// Testing

scriptedBufferLog := false

scriptedLaunchOpts := scriptedLaunchOpts.value ++ Seq(
  "-Xmx1024M", "-Dplugin.version=" + version.value
)

test := {
  (Test / test).value
  scripted.toTask("").value
}
