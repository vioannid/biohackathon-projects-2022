/** Elixir BioHackathon 2022 */
package com.elixir.biohackaton.ISAToSRA.sra;

import com.elixir.biohackaton.ISAToSRA.model.Investigation;
import com.elixir.biohackaton.ISAToSRA.model.IsaJson;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

@Service
public class SRAProjectXmlCreator {
  public void create(final IsaJson isaJson, final Element webinElement) {
    final Element projectSetElement = webinElement.addElement("PROJECT_SET");
    final Element projectElement = projectSetElement.addElement("PROJECT");
    final Investigation investigation = isaJson.getInvestigation();

    projectElement.addAttribute("alias", investigation.getTitle());
    projectElement.addElement("TITLE").addText(investigation.getTitle());
    projectElement.addElement("DESCRIPTION").addText(investigation.getDescription());

    final Element submissionProjectElement = projectElement.addElement("SUBMISSION_PROJECT");
    submissionProjectElement.addElement("SEQUENCING_PROJECT");
  }
}
