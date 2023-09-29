package com.javax0.jamal.gradle.plugin

import org.gradle.testfixtures.ProjectBuilder
import org.junit.Assert.assertNotNull
import org.junit.Test
import java.io.File

class JamalPluginTest {

    @Test
    fun `plugin is applied correctly to the project`() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("jamal-gradle-plugin")

        assert(project.tasks.getByName("JamalConvertFile") is JamalFileConverterTask)
    }

    @Test
    fun `extension templateExampleConfig is created correctly`() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("jamal-gradle-plugin")

        assertNotNull(project.extensions.getByName("JamalConvertFile"))
    }

    @Test
    fun `parameters are passed correctly from extension to task`() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("jamal-gradle-plugin")
        val aFile = File(project.projectDir, ".tmp")
        (project.extensions.getByName("JamalConvertFile") as JamalExtension).apply {
            inputFile.set(File("a-sample-input.adoc.jam"))
        }

        val task = project.tasks.getByName("JamalConvertFile") as JamalFileConverterTask

    }
}
