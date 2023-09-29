package com.javax0.jamal.gradle.plugin

import org.gradle.api.Project
import org.gradle.api.file.RegularFileProperty
import java.io.File
import javax.inject.Inject

@Suppress("UnnecessaryAbstractClass")
abstract class JamalExtension @Inject constructor(project: Project) {

    private val objects = project.objects

    val inputFile: RegularFileProperty = objects.fileProperty()

    val outputFile: RegularFileProperty = objects.fileProperty().convention(
        inputFile.map { objects.fileProperty().fileValue(File(it.asFile.nameWithoutExtension)).get() }
    )

}
