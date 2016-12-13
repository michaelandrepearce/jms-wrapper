//package org.apache.kafka;
//
///**
// * Created by michaelandrepearce on 11/12/2016.
// */
//public class ProducerRecord {
//
//    /**
//     * Creates a record with a specified timestamp to be sent to a specified topic and partition
//     *
//     * @param topic The topic the record will be appended to
//     * @param partition The partition to which the record should be sent
//     * @param timestamp The timestamp of the record
//     * @param tombstone if the record should be treated as a tombstone if the topic is compacted
//     * @param key The key that will be included in the record
//     * @param value The record contents
//     */
//    public ProducerRecord(String topic, Integer partition, Boolean tombstone, Long timestamp, K key, V value) {
//        if (topic == null)
//            throw new IllegalArgumentException("Topic cannot be null.");
//        if (timestamp != null && timestamp < 0)
//            throw new IllegalArgumentException(
//                    String.format("Invalid timestamp: %d. Timestamp should always be non-negative or null.", timestamp));
//        if (partition != null && partition < 0)
//            throw new IllegalArgumentException(
//                    String.format("Invalid partition: %d. Partition number should always be non-negative or null.", partition));
//        if (!tombstone && value == null){
//            throw new IllegalArgumentException(
//                    String.format("Tombstone must be true if null value"));
//        }
//        this.topic = topic;
//        this.partition = partition;
//        this.tombstone = tombstone;
//        this.key = key;
//        this.value = value;
//        this.timestamp = timestamp;
//    }
//
//    public ProducerRecord(String topic, Integer partition, Long timestamp, K key, V value) {
//        this(topic, partition, value == null, timestamp, key, value);
//    }
//
//        /**
//         * Creates a record to be sent to a specified topic and partition
//         *
//         * @param topic The topic the record will be appended to
//         * @param partition The partition to which the record should be sent
//         * @param key The key that will be included in the record
//         * @param value The record contents
//         */
//    public ProducerRecord(String topic, Integer partition, K key, V value) {
//        this(topic, partition, null, key, value);
//    }
//
//    /**
//     * Create a record to be sent to Kafka
//     *
//     * @param topic The topic the record will be appended to
//     * @param key The key that will be included in the record
//     * @param value The record contents
//     */
//    public ProducerRecord(String topic, K key, V value) {
//        this(topic, null, null, key, value);
//    }
//
//    /**
//     * Create a record with no key
//     *
//     * @param topic The topic this record should be sent to
//     * @param value The record contents
//     */
//    public ProducerRecord(String topic, V value) {
//        this(topic, null, null, null, value);
//    }
//
//
//
//}
