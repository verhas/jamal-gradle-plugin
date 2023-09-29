package com.javax0.jamal.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

const val EXTENSION_NAME = "JamalConvertFile"
const val TASK_NAME = "JamalConvertFile"

abstract class JamalPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create(EXTENSION_NAME, JamalExtension::class.java, project)

        // Add a task that uses configuration from the extension object
        project.tasks.register(TASK_NAME, JamalFileConverterTask::class.java) {
            it.inputFile.set(extension.inputFile)
            it.outputFile.set(extension.outputFile)
        }
    }
}
