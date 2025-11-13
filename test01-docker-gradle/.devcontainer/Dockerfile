FROM ubuntu:latest

ARG JAVA_VERSION=21
ARG WILDFLY_VERSION=38.0.0.Final
ARG POSTGRES_VERSION=42.7.8
ARG GRADLE_VERSION=8.6
ENV WILDFLY_HOME=/opt/wildfly
ENV WILDFLY_ADMIN=admin
ENV WILDFLY_ADMIN_PASS=password
ENV DS_NAME=PostgresDS
ENV DS_JNDI=java:/PostgresDS
ENV DB_HOST=postgres
ENV DB_PORT=5432
ENV DB_NAME=postgres
ENV DB_USER=user
ENV DB_PASS=password
ENV JAVA_HOME=/usr/lib/jvm/java-${JAVA_VERSION}-openjdk-amd64
ENV GRADLE_HOME=/opt/gradle/gradle-${GRADLE_VERSION}
ENV PATH="${GRADLE_HOME}/bin:${JAVA_HOME}/bin:${PATH}"

RUN apt-get update && apt-get install -y \
    openjdk-${JAVA_VERSION}-jdk \
    curl \
    unzip \
    vim \
    procps \
    net-tools \
    gettext \
    && rm -rf /var/lib/apt/lists/*

RUN mkdir -p /opt/gradle \
    && curl -L -o /tmp/gradle.zip https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip /tmp/gradle.zip -d /opt/gradle \
    && rm /tmp/gradle.zip \
    && chown -R root:root /opt/gradle

RUN curl -L -o /tmp/wildfly.zip https://github.com/wildfly/wildfly/releases/download/${WILDFLY_VERSION}/wildfly-${WILDFLY_VERSION}.zip \
    && unzip /tmp/wildfly.zip -d /opt \
    && mv /opt/wildfly-${WILDFLY_VERSION} ${WILDFLY_HOME} \
    && rm /tmp/wildfly.zip

RUN curl -L -o ${WILDFLY_HOME}/standalone/deployments/postgresql-${POSTGRES_VERSION}.jar https://repo1.maven.org/maven2/org/postgresql/postgresql/${POSTGRES_VERSION}/postgresql-${POSTGRES_VERSION}.jar

RUN ${WILDFLY_HOME}/bin/add-user.sh ${WILDFLY_ADMIN} ${WILDFLY_ADMIN_PASS} --silent

RUN groupadd -r vscode && useradd -r -g vscode -m -s /bin/bash vscode \
    && chown -R vscode:vscode ${WILDFLY_HOME}

COPY configure-postgres.cli /tmp/configure-postgres.cli

RUN envsubst < /tmp/configure-postgres.cli > /tmp/configure-postgres.expanded.cli \
    && ${WILDFLY_HOME}/bin/jboss-cli.sh --file=/tmp/configure-postgres.expanded.cli

COPY entrypoint.sh /entrypoint.sh

RUN chmod +x /entrypoint.sh

EXPOSE 8080 8787 9990

ENTRYPOINT ["/entrypoint.sh"]
