import org.openWeatherMap.forecast.task.UpdateTask

import static org.openWeatherMap.forecast.config.ApplicationConfig.SCHEDULER_CRON
import static org.openWeatherMap.forecast.config.ApplicationConfig.getConfigValue

beans = {

    updateTask(UpdateTask) {
    }

    xmlns task: "http://www.springframework.org/schema/task"

    /**
     * Scheduled task for automatic forecast updates based on the cron provided in app config.
     */
    task.'scheduled-tasks' {
        task.scheduled(ref: 'updateTask', method: 'executeTask', cron: getConfigValue(SCHEDULER_CRON), initialDelay: 10000000)
    }
}