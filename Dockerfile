FROM registry.correios.com.br:5043/debian_corretto:java11

WORKDIR /opt/sistemas

ENV JAVA_TOOL_OPTIONS="-Duser.country=BR -Duser.language=pt"

ADD . /opt/sistemas

USER webadmin

CMD ["/opt/java/amazon-corretto-11.0.4.11.1-linux-x64/bin/java", "-jar", "sara-atendimento.jar"]