import mill._
import mill.scalalib._

trait MyScalaModule extends ScalaModule { outer =>
  override def scalaVersion = "2.12.4"
  trait MyTests extends Tests {
    override def moduleDeps = outer :: outer.moduleDeps.toList
    override def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.0.4")
    override def testFrameworks = Seq("org.scalatest.tools.Framework")
  }
}

object demo extends MyScalaModule {
  override def ivyDeps = Agg(
    ivy"com.github.tototoshi::scala-csv:1.3.5",
    ivy"org.scala-lang:scala-reflect:${scalaVersion()}"
  )
  object test extends MyTests
}
