package record.utils.gzip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GzipRedisSerializer implements RedisSerializer<String> {

    private final Charset charset;

    public GzipRedisSerializer(Charset charset) {
        this.charset = charset;
    }

    public GzipRedisSerializer() {
        this(StandardCharsets.UTF_8);
    }

    @Override
    public byte[] serialize(String s) throws SerializationException {
        if (StringUtils.isBlank(s)) {
            return new byte[0];
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GZIPOutputStream gzip = new GZIPOutputStream(out)) {
            gzip.write(s.getBytes(charset));
        } catch (Exception e) {
            log.error("GzipRedisSerializer压缩异常", e);
        }
        return out.toByteArray();
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try (GZIPInputStream gzip = new GZIPInputStream(in)) {
            byte[] buffer = new byte[512];
            int offset;
            while ((offset = gzip.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
        } catch (Exception e) {
            log.error("GzipRedisSerializer解压缩异常", e);
        }
        return new String(out.toByteArray(), charset);
    }

}
