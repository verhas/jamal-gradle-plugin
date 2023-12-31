package com.javax0.jamal.gradle.plugin

import javax0.jamal.DocumentConverter
import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.plugins.BasePlugin
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.options.Option

abstract class JamalFileConverterTask : DefaultTask() {


    init {
        description = "Jamal file converter"
        group = BasePlugin.BUILD_GROUP
    }

    @get:InputFile
    @get:Option(option = "jam", description = "the Jamal source file to be processed")
    abstract val inputFile: RegularFileProperty

    @get:OutputFile
    @get:Option(
        option = "out",
        description = "the output file, optional, where the result of the processing is written"
    )
    @get:Optional
    abstract val outputFile: RegularFileProperty

    @TaskAction
    fun convertDocument() {

        logger.lifecycle("Jamal ${inputFile.get()} -> ${outputFile.get()}")
        DocumentConverter.convert(inputFile.asFile.get().absolutePath)
    }
}
