package com.mayank.framepulse.api

/**
 * Configuration for a FramePulse monitoring session.
 *
 * Responsibilities:
 * - Capture policy knobs that affect metrics interpretation (window size, frame budget).
 * - Remain immutable for the lifetime of a session.
 *
 * Must not:
 * - Hold runtime monitoring state or listener references.
 * - Reference Android UI components.
 *
 * Future role:
 * - May gain optional refresh-rate hints and listener throttle settings without breaking callers.
 */
data class FramePulseConfig(
    val windowDurationMs: Long = DEFAULT_WINDOW_DURATION_MS,
    val expectedFramePeriodMs: Float = DEFAULT_EXPECTED_FRAME_PERIOD_MS,
) {
    companion object {
        /** Default configuration for [FramePulse.start]. */
        val DEFAULT: FramePulseConfig = FramePulseConfig()

        const val DEFAULT_WINDOW_DURATION_MS: Long = 1_000L
        const val DEFAULT_EXPECTED_FRAME_PERIOD_MS: Float = 16.67f
    }
}
