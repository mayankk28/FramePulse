package com.mayank.framepulse.api

/**
 * Handle for an active FramePulse monitoring session.
 *
 * Responsibilities:
 * - Represent session lifecycle (running vs stopped).
 * - Provide explicit [stop] so frame callbacks are unregistered and resources are released.
 *
 * Must not:
 * - Expose internal monitor or metrics types to callers.
 * - Restart itself; start a new session via [FramePulse.start] instead.
 *
 * Future role:
 * - Owned by host apps; stopped from lifecycle boundaries (e.g. when UI is no longer visible).
 */
interface FramePulseSession {

    /** Stops monitoring and prevents further listener invocations. */
    fun stop()

    /** Whether the session is actively receiving frame signals. */
    val isRunning: Boolean
}
