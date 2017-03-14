name := "monitoringApp"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.apache.commons" % "commons-email" % "1.4"
)     

play.Project.playJavaSettings

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.27"
