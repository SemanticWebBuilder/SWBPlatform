/*
 * SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
 * colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
 * información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
 * fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
 * procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
 * para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
 *
 * INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público ('open source'),
 * en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
 * aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
 * del SemanticWebBuilder 4.0.
 *
 * INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
 * siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
 * dirección electrónica: http://www.semanticwebbuilder.org.mx
 */
package org.semanticwb.platform;

import com.hp.hpl.jena.ontology.Restriction;
import org.semanticwb.SWBPlatform;

/**
 * Class to encapsulate an ontology restriction ({@link Restriction}) in SWBOntology.
 * @author javier.solis
 */
public class SemanticRestriction extends SemanticClass {
    /**
     * Constructor. Instantiates a new {@link SemanticRestriction}.
     * @param res the base Restriction object.
     */
    public SemanticRestriction(Restriction res) {
        super(res);
    }

    /**
     * Checks if is this restriction is an all-values-from restriction.
     * @return true, if this restriction is an all-values-from restriction.
     */
    public boolean isAllValuesFromRestriction() {
        return ((Restriction) getOntClass()).isAllValuesFromRestriction();
    }

    /**
     * Checks if is this restriction is an is-some-values-from restriction.
     * @return true, if this restriction is an is-some-values-from restriction.
     */
    public boolean isSomeValuesFromRestriction() {
        return ((Restriction) getOntClass()).isSomeValuesFromRestriction();
    }

    /**
     * Checks if is this restriction is a cardinality restriction.
     * @return true, if this restriction is a cardinality restriction.
     */
    public boolean isCardinalityRestriction() {
        return ((Restriction) getOntClass()).isCardinalityRestriction();
    }

    /**
     * Checks if is this restriction is a has-values restriction.
     * @return true, if this restriction is a has-values restriction.
     */
    public boolean isHasValueRestriction() {
        return ((Restriction) getOntClass()).isHasValueRestriction();
    }

    /**
     * Checks if is this restriction is a is-max-cardinality restriction.
     * @return true, if this restriction is a is-max-cardinality restriction.
     */
    public boolean isMaxCardinalityRestriction() {
        return ((Restriction) getOntClass()).isMaxCardinalityRestriction();
    }

    /**
     * Checks if is this restriction is a is-min-cardinality restriction.
     * @return true, if this restriction is a is-min-cardinality restriction.
     */
    public boolean isMinCardinalityRestriction() {
        return ((Restriction) getOntClass()).isMinCardinalityRestriction();
    }

    /**
     * Gets the restriction value as a {@link SemanticClass}.
     * @return the restriction value
     */
    public SemanticClass getRestrictionValue() {
        SemanticClass cls = null;
        Restriction res = ((Restriction) getOntClass());
        if (res.isAllValuesFromRestriction()) {
            cls = SWBPlatform.getSemanticMgr().getVocabulary()
                    .getSemanticClass(res.asAllValuesFromRestriction().getAllValuesFrom().getURI());
        } else if (res.isSomeValuesFromRestriction()) {
            cls = SWBPlatform.getSemanticMgr().getVocabulary()
                    .getSemanticClass(res.asSomeValuesFromRestriction().getSomeValuesFrom().getURI());
        }
        return cls;
    }
}