import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaRDD;
import static org.apache.spark.mllib.random.RandomRDDs.*;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.stat.MultivariateStatisticalSummary;
import org.apache.spark.mllib.stat.Statistics;

/**
 * Created by krushika on 22/9/16.
 */
public class Main {

    public static void main(String [] args){
        SparkConf conf = new SparkConf();
        JavaSparkContext sparkContext = new JavaSparkContext(conf.setMaster("local").setAppName("STATS-TEST"));
        JavaRDD<Vector> u = normalJavaVectorRDD(sparkContext,100L,5);
//        JavaRDD<Vector> v = u.map(new Function<Vector, Vector>() {
//            public Vector call(Vector vector) throws Exception {
//                return vector;
//            }
//        });

        MultivariateStatisticalSummary summary = Statistics.colStats(u.rdd());
//        System.out.println(u.first());
        System.out.println(summary.mean());
        System.out.println(summary.variance());
    }
}


