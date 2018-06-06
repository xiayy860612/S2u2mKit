package s2u2msdk.spring.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.robwin.markup.builder.MarkupLanguage;
import io.github.robwin.swagger2markup.GroupBy;
import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import springfox.documentation.staticdocs.SwaggerResultHandler;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * class AbS2u2mControllerTest
 *
 * @author xiayy860612
 * @date 2018/5/19
 */
@AutoConfigureRestDocs(outputDir = SwaggerExportConfig.SnipDir)
@AutoConfigureMockMvc
public abstract class AbS2u2mControllerTest extends AbS2u2mSpringTest {

    @Autowired
    protected MockMvc mockMvc;

    @After
    public void export() throws Exception {
        mockMvc.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
                .andDo(SwaggerResultHandler.outputDirectory(SwaggerExportConfig.OutputDir).build())
                .andExpect(status().isOk())
                .andReturn();

        Swagger2MarkupConverter.from(SwaggerExportConfig.OutputDir + "/swagger.json")
                // 按tag排序
                .withPathsGroupedBy(GroupBy.TAGS)
                // 格式
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withExamples(SwaggerExportConfig.SnipDir)
                .build()
                .intoFolder(SwaggerExportConfig.OutputDir);
    }

    protected <RT> RT convertResponseToObject(MvcResult result, Class<RT> ct) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(result.getResponse().getContentAsString(), ct);
    }

    protected final ResultHandler documentAPI(String id) {
        return document(id, preprocessResponse(prettyPrint()));
    }
}
