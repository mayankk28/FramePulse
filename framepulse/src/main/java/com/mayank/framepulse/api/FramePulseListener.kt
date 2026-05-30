package com.mayank.framepulse.api

import com.mayank.framepulse.model.FrameMetrics

/**
 * Callback invoked when aggregated frame metrics are available.
 *
 * Responsibilities:
 * - Consume immutable [FrameMetrics] snapshots produced by the metrics layer.
 * - Stay lightweight; heavy work in listeners can itself cause UI-thread pressure.
 *
 * Must not:
 * - Drive monitoring lifecycle (use [FramePulseSession] instead).
 * - Mutate or retain metrics beyond the callback scope unless copied intentionally.
 *
 * Future role:
 * - Primary push-based integration point for the demo app, logging, and debug overlays.
 */
fun interface FramePulseListener {

    /**
     * Called with the latest aggregated metrics for the configured window.
     *
     * @param metrics Immutable snapshot; safe to read on the invoking thread.
     */
    fun onMetrics(metrics: FrameMetrics)
}
