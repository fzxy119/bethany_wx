[#ftl strip_whitespace=true]
<#--
 * message
 *
 * Macro to translate a message code into a message.
 -->
 [#macro L code]${springMacroRequestContext.getMessage(code)}[/#macro]

 [#macro L code value]${springMacroRequestContext.getMessage(code+value)}[/#macro]

<#--
 * messageText
 *
 * Macro to translate a message code into a message,
 * using the given default text if no message found.
 -->
[#macro LT code, text]${springMacroRequestContext.getMessage(code, text)}[/#macro]

<#--
 * messageArgs
 *
 * Macro to translate a message code with arguments into a message.
 -->
[#macro LA code, args]${springMacroRequestContext.getMessage(code, args)}[/#macro]

<#--
 * messageArgsText
 *
 * Macro to translate a message code with arguments into a message,
 * using the given default text if no message found.
 -->
[#macro LAT code, args, text]${springMacroRequestContext.getMessage(code, args, text)}[/#macro]

