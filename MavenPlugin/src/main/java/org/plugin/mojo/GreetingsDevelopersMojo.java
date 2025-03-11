package org.plugin.mojo;

import org.apache.maven.model.Contributor;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(name = "greet", defaultPhase = LifecyclePhase.CLEAN)
public class GreetingsDevelopersMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    /**
     * Можно красиво разбирать объект {@link Contributor}
     * при желании...
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Project ArtifactId: " + project.getArtifactId());
        getLog().info("Project Version: " + project.getVersion());
        getLog().info("Project Packaging: " + project.getPackaging());

        getLog().info("Developers:");

        project.getDevelopers().forEach(developer ->
                getLog().info(developer.toString())
        );
        /*
        List<Contributor> developers = project.getDevelopers();
        developers.forEach(dev -> getLog().info(
                dev.getName()
                + dev.getEmail()
                + dev.getOrganization()
        ));
        */
    }
}
