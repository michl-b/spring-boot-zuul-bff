package de.michlb.demo.customer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.TreeMap;

import de.michlb.demo.customer.constant.ApiConstants;

/**
 * <pre>Provides build/git related details</pre>
 */
@RestController
public class BuildController {

    private TreeMap<String, Object> build = new TreeMap<>();

    @Value("${git.commit.id.abbrev}")
    private String gitCommitAbbrevVal;
    private static String gitCommitAbbrevKey = "git.commit.id.abbrev";

    @Value("${git.commit.user.email}")
    private String gitCommitEmailVal;
    private static String gitCommitEmailKey = "git.commit.user.email";

    @Value("${git.commit.message.full}")
    private String gitCommitMsgVal;
    private static String gitCommitMsgKey = "git.commit.message.full";

    @Value("${git.commit.id}")
    private String gitCommitIdVal;
    private static String gitCommitIdKey = "git.commit.id";

    @Value("${git.commit.user.name}")
    private String gitCommitUsernameVal;
    private static String gitCommitUsernamekey = "git.commit.user.name";

    @Value("${git.commit.id.describe}")
    private String gitCommitDescVal;
    private static String gitCommitDescKey = "git.commit.id.describe";

    @Value("${git.build.user.email}")
    private String gitBuildEmailVal;
    private static String gitBuildEmailKey = "git.build.user.email";

    @Value("${git.branch}")
    private String gitBranchVal;
    private static String gitBranchKey = "git.branch";

    @Value("${git.commit.time}")
    private String gitCommitTimeVal;
    private static String gitCommitTimeKey = "git.commit.time";

    @Value("${git.build.time}")
    private String gitBuildTimeVal;
    private static String gitBuildTimeKey = "git.build.time";

    @Value("${git.remote.origin.url}")
    private String gitOriginVal;
    private static String gitOriginKey = "git.remote.origin.url";

    @Value("${info.app.maven.version}")
    private String mavenVersionVal;
    private static String mavenVersionKey = "maven.version";

    @Value("${info.app.maven.artifactId}")
    private String mavenArtifactIdVal;
    private static String mavenArtifactIdKey = "maven.artifactId";

    @Value("${info.app.maven.groupId}")
    private String mavenGroupIdVal;
    private static String mavenGroupIdKey = "maven.groupId";

    @Value("${spring.profiles.active}")
    private String springProfileVal;
    private static String springProfileKey = "spring.profiles.active";

    @Value("${spring.application.name}")
    private String springAppNameVal;
    private static String springAppNameKey = "spring.application.name";

    @Value("${server.port}")
    private int springPortVal;
    private static String springPortKey = "spring.server.port";

    @PostConstruct
    public void setup() {
        build.put(springProfileKey, springProfileVal);
        build.put(springAppNameKey, springAppNameVal);
        build.put(springPortKey, springPortVal);
        build.put(mavenVersionKey, mavenVersionVal);
        build.put(mavenArtifactIdKey, mavenArtifactIdVal);
        build.put(mavenGroupIdKey, mavenGroupIdVal);
        build.put(gitCommitAbbrevKey, gitCommitAbbrevVal);
        build.put(gitCommitEmailKey, gitCommitEmailVal);
        build.put(gitCommitMsgKey, gitCommitMsgVal);
        build.put(gitCommitIdKey, gitCommitIdVal);
        build.put(gitCommitUsernamekey, gitCommitUsernameVal);
        build.put(gitCommitDescKey, gitCommitDescVal);
        build.put(gitBuildEmailKey, gitBuildEmailVal);
        build.put(gitBranchKey, gitBranchVal);
        build.put(gitCommitTimeKey, gitCommitTimeVal);
        build.put(gitBuildTimeKey, gitBuildTimeVal);
        build.put(gitOriginKey, gitOriginVal);
    }

    @RequestMapping(ApiConstants.API_MAN_BUILD)
    public Map<String, Object> build() {
        return build;
    }

}
