package com.mook.plugin.gr_maven_plugin;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "gen")//, defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CodeGen extends AbstractMojo {
    
    
    @Parameter( defaultValue = "${project.build.directory}")
    private File outputDirectory;

    @Parameter( defaultValue = "${project.basedir}/src/main/java")
    private File javaFolder;
    public void execute() throws MojoExecutionException, MojoFailureException 
    {
        try {

        System.out.println(outputDirectory.getAbsolutePath());
        System.out.println(javaFolder.getAbsolutePath());
        File file = new File(javaFolder + "/test.java");
        String data = "public class test {}";
		FileUtils.writeStringToFile(file, data, "utf-8");
		} catch (Exception e) 
        {
			e.printStackTrace();
			throw new MojoFailureException(e.getMessage());
		}
    }

}