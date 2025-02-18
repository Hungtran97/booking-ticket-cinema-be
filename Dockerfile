# Sử dụng image Maven để build ứng dụng
FROM maven:3-eclipse-temurin-21 AS builder

# Đặt thư mục làm việc trong container
WORKDIR /app

# Copy toàn bộ mã nguồn vào container
COPY . /app

# Đặt quyền truy cập root
USER root

# Tìm kiếm tệp .env.properties trong container
RUN find / -name "secrets"


# Build ứng dụng bằng Maven
RUN mvn clean package -Prender -DskipTests

# Sử dụng image Java để chạy ứng dụng
FROM eclipse-temurin:21-jdk-alpine

# Copy tệp JAR đã build từ builder image vào container
COPY --from=builder /app/target/booking-ticket-cinema-be-0.0.1-SNAPSHOT.jar /app/booking-ticket-cinema-be-0.0.1-SNAPSHOT.jar

# Mở cổng 8080 cho ứng dụng
EXPOSE 8080

# Chạy ứng dụng
ENTRYPOINT ["java", "-jar", "/app/booking-ticket-cinema-be-0.0.1-SNAPSHOT.jar"]
