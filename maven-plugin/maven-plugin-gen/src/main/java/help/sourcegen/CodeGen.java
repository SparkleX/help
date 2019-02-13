package help.sourcegen;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

@Mojo(name = "gen", requiresDependencyResolution = ResolutionScope.COMPILE, defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CodeGen extends AbstractMojo {
    
    
    @Parameter( defaultValue = "${project.build.directory}")
    private File outputDirectory;

    @Parameter( defaultValue = "${project.basedir}/target/generated-sources/java")
    private File javaFolder;
    
	@Parameter( defaultValue = "${project}")
	private MavenProject project;
    
    public void execute() throws MojoExecutionException, MojoFailureException 
    {
    	
        try {

        System.out.println(outputDirectory.getAbsolutePath());
        System.out.println(javaFolder.getAbsolutePath());
        File file = new File(javaFolder + "/test/SalesOrder.java");
        String data = "package test;\npublic class SalesOrder {}";
		FileUtils.writeStringToFile(file, data, "utf-8");
		project.addCompileSourceRoot(javaFolder.getPath());
		} catch (Exception e) 
        {
			e.printStackTrace();
			throw new MojoFailureException(e.getMessage());
		}
        
    }

}