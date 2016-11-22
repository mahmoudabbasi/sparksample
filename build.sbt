name := "sparksample"

version := "1.0"


scalaVersion := "2.10.4"

libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "1.3.1" ,
                           "org.apache.spark" %% "spark-sql" % "1.3.1"
                          )

unmanagedJars in Compile += file("D:/Projects/sparksample/lib/db2jcc4.jar")

// libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.1.0"

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"


    