@XmlSchema(namespace = "http://www.fnac.com/schemas/mp-dialog.xsd", elementFormDefault = XmlNsForm.QUALIFIED)
package com.api.xmlEntity.order;

/**
 * 解决xml带有命名空间导致的JAXB解析失败
 */

import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;
