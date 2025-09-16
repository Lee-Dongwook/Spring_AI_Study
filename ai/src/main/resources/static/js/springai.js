springai.printAnswerText = async function (
  responseBody,
  targetId,
  chatPanelId
) {
  springai.printAnswerStreamText(responseBody, targetId, chatPanelId);
};

springai.printAnswerStreamText = async function (
  responseBody,
  targetId,
  chatPanelId
) {
  const targetElement = document.getElementById(targetId);
  const reader = responseBody.getReader();
  const decoder = new TextDecoder("utf-8");

  let content = "";

  while (true) {
    const { value, done } = await reader.read();

    if (done) break;

    let chunk = decoder.decode(value);

    content += chunk;

    if (!springai.isOpenTagIncomplete(chunk)) {
      targetElement.innerHTML = content;
    }

    springai.scrollToHeight(chatPanelId);
  }
};
